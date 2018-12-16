package com.blog.server;

import com.mongodb.BasicDBObject;
import com.mongodb.client.*;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.proto.blog.*;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.Iterator;

import static com.mongodb.client.model.Filters.eq;


public class BlogServiceImpl  extends BlogServiceGrpc.BlogServiceImplBase{

    private MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
    private MongoDatabase mongoDatabase = mongoClient.getDatabase("grpc");
    private MongoCollection<Document>  collection = mongoDatabase.getCollection("blog");

    @Override
    public void createBlog(CreateBlogRequest request, StreamObserver<CreateBlogResponse> responseObserver) {

        Blog blog = request.getBlog();

        Document doc =  new Document("author",blog.getAuthor())
                .append("title",blog.getTitle())
                .append("content",blog.getContent());

        collection.insertOne(doc);

        String id = doc.get("_id").toString();

        CreateBlogResponse response = CreateBlogResponse.newBuilder()
                .setBlog(blog.toBuilder().setId(id).build())
                .build();

        responseObserver.onNext(response);

        responseObserver.onCompleted();

    }


    @Override
    public void readBlog(ReadBlogRequest request, StreamObserver<ReadBlogResponse> responseObserver) {
        String id = request.getId();
        Document result=null;
        try {
            result = collection.find(eq("_id", new ObjectId(id))).first();
        } catch (Exception e){
            responseObserver.onError(Status.NOT_FOUND.withDescription("Document with ID :"+id+" not found.")
                    .augmentDescription(e.getLocalizedMessage()).asRuntimeException());
        }

        if(result==null)
        {
            responseObserver.onError(Status.NOT_FOUND.withDescription("Document with ID :"+id+"not found.").asRuntimeException());

        } else {

            ReadBlogResponse readBlogResponse = ReadBlogResponse.newBuilder()
                    .setBlog(Blog.newBuilder()
                            .setTitle(result.getString("title"))
                            .setAuthor(result.getString("author"))
                            .setContent(result.getString("content"))
                            .build())
                    .build();
            responseObserver.onNext(readBlogResponse);
        }

        responseObserver.onCompleted();
    }


    @Override
    public void updateBlog(UpdateBlogRequest request, StreamObserver<UpdateBlogResponse> responseObserver) {
        Blog blog = request.getBlog();
        Document result = null;
        try {
            result = collection.find(eq("_id", new ObjectId(blog.getId()))).first();
        } catch (Exception e){
            responseObserver.onError(Status.NOT_FOUND
                    .withDescription("Document with ID : "+blog.getId()+" not found")
                    .asRuntimeException());
        }

        if(result==null){
            responseObserver.onError(Status.NOT_FOUND
                    .withDescription("Document with ID : "+blog.getId()+" not found")
                    .asRuntimeException());
        } else {

            Document newDoc = new Document("author",blog.getAuthor())
                    .append("title",blog.getTitle())
                    .append("content",blog.getContent());

            collection.replaceOne(eq("_id",blog.getId()),newDoc);

            UpdateBlogResponse response = UpdateBlogResponse.newBuilder()
                    .setBlog(Blog.newBuilder()
                            .setId(result.get("_id").toString())
                            .setAuthor(newDoc.getString("author"))
                            .setTitle(newDoc.getString("title"))
                            .setContent(newDoc.getString("content"))
                            .build())
                    .build();

            responseObserver.onNext(response);
        }

        responseObserver.onCompleted();
    }


    @Override
    public void deleteBlog(DeleteBlogRequest request, StreamObserver<DeleteBlogResponse> responseObserver) {

        String id = request.getId();
        DeleteResult result = null;

        try {
            result = collection.deleteOne(eq("_id", new ObjectId(id)));
        } catch (Exception e){
            responseObserver.onError(Status.NOT_FOUND
                    .withDescription("Document with ID : "+id+" not found")
                    .asRuntimeException());
        }

        if(result.getDeletedCount()!=0){
            DeleteBlogResponse response = DeleteBlogResponse.newBuilder()
                    .setRowCount(result.getDeletedCount())
                    .build();
            responseObserver.onNext(response);

        } else {
            responseObserver.onError(Status.NOT_FOUND
                    .withDescription("No Record is deleted")
                    .asRuntimeException());
        }

        responseObserver.onCompleted();
    }


    @Override
    public void listAllBlogs(ListBlogRequest request, StreamObserver<ListBlogResponse> responseObserver) {

        Iterator<Document> it = collection.find().iterator();
        it.forEachRemaining(document -> {
            //System.out.println(document.toString());
            responseObserver.onNext(ListBlogResponse.newBuilder()
                    .setBlog(docToBlog(document))
                    .build()
            );

        });
        responseObserver.onCompleted();
    }

    public Blog docToBlog(Document doc){

       return Blog.newBuilder()
                .setId(doc.get("_id").toString())
                .setAuthor(doc.getString("author"))
                .setTitle(doc.getString("title"))
                .setContent(doc.getString("content"))
                .build();
    }
}
