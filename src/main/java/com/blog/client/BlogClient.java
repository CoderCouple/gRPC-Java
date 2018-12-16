package com.blog.client;


import com.google.protobuf.InvalidProtocolBufferException;

import com.proto.blog.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Iterator;

public class BlogClient {

    private void run() throws InvalidProtocolBufferException {

        System.out.println("Creating the chanel");
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 50055)
                //this method is used to remove the ALPN error related to security
                .usePlaintext(true)
                .build();

        createBlog(channel);
        readBlog(channel);
        updateBlog(channel);
        deleteBlog(channel);
        listAllBlog(channel);


        System.out.println("Closing the chanel");
        channel.shutdown();
    }

    private void createBlog(ManagedChannel channel) throws InvalidProtocolBufferException {

        BlogServiceGrpc.BlogServiceBlockingStub syncClient=BlogServiceGrpc.newBlockingStub(channel);

        Blog blog = Blog.newBuilder()
                .setAuthor("Payal")
                .setTitle("Our love story")
                .setContent("I love you too")
                .build();

        CreateBlogRequest request = CreateBlogRequest.newBuilder()
                .setBlog(blog)
                .build();

        System.out.println("Sent create blog request.");
        CreateBlogResponse response =syncClient.createBlog(request);

        System.out.println("Received blog response.");
        System.out.println(response.toString());

    }

    private void readBlog(ManagedChannel channel)  {

        BlogServiceGrpc.BlogServiceBlockingStub syncClient = BlogServiceGrpc.newBlockingStub(channel);
        String id ="5c14664bf473de9a3c8d1239";

        ReadBlogRequest readBlogRequest = ReadBlogRequest.newBuilder()
                .setId(id)
                .build();

        ReadBlogResponse readBlogResponse = syncClient.readBlog(readBlogRequest);

        System.out.println(readBlogResponse.toString());
    }


    private void updateBlog(ManagedChannel channel)  {

        BlogServiceGrpc.BlogServiceBlockingStub syncClient = BlogServiceGrpc.newBlockingStub(channel);

        Blog blog = Blog.newBuilder()
                .setId("5c14664bf473de9a3c8d1239")
                .setAuthor("Payal")
                .setTitle("Our love story")
                .setContent("Our love story is updated")
                .build();

        UpdateBlogRequest updateBlogRequest = UpdateBlogRequest.newBuilder()
                .setBlog(blog)
                .build();

        UpdateBlogResponse updateBlogResponse = syncClient.updateBlog(updateBlogRequest);

        System.out.println(updateBlogResponse.toString());
    }

    private void deleteBlog(ManagedChannel channel)  {

        BlogServiceGrpc.BlogServiceBlockingStub syncClient = BlogServiceGrpc.newBlockingStub(channel);
        String id ="5c14664bf473de9a3c8d1239";

        DeleteBlogRequest deleteBlogRequest = DeleteBlogRequest.newBuilder()
                .setId(id)
                .build();

        DeleteBlogResponse deleteBlogResponse = syncClient.deleteBlog(deleteBlogRequest);

        System.out.println(deleteBlogResponse.toString());
    }

    private void listAllBlog(ManagedChannel channel)  {

        BlogServiceGrpc.BlogServiceBlockingStub syncClient = BlogServiceGrpc.newBlockingStub(channel);


        ListBlogRequest listBlogRequest = ListBlogRequest.newBuilder()
                .build();

        Iterator<ListBlogResponse> it = syncClient.listAllBlogs(listBlogRequest);

        while (it.hasNext()){
            System.out.println(it.next().getBlog().toString());
        }

    }

    public static void main(String[] args) throws InvalidProtocolBufferException {

        System.out.println("Hi I am a gRPC client ...!!!");

        BlogClient bc = new BlogClient();
        bc.run();

    }
}
