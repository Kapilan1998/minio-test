package com.spring.security.self;

import io.minio.MinioClient;
import io.minio.errors.MinioException;
import io.minio.messages.Bucket;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MinioClient minioClient = connectMiniIO();
        try {
            List<Bucket> bucketList = minioClient.listBuckets();
            System.out.println("Connection success, total buckets : " + bucketList.size());
            System.out.println("Available buckets "+bucketList);
        } catch (MinioException e) {
            System.out.println("Connection failed " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static MinioClient connectMiniIO() {
        MinioClient minioClient = MinioClient
                .builder()
                .endpoint("http://127.0.0.1:9000")
                .credentials("z41zauxboTGZ9DYnDaji","KDeRE3Vsnd2FCieb0VXNqtNxQcQNsQwUpOJu47zS")
                .build();

        return minioClient;
    }
}