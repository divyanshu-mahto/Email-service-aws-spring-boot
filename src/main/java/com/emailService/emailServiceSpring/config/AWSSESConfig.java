package com.emailService.emailServiceSpring.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sesv2.SesV2Client;

@Configuration
public class AWSSESConfig {

    @Bean
    public SesV2Client sesV2Client() {
        Dotenv dotenv = Dotenv.configure()
                .directory("D:\\Program_Files\\emailServiceSpring\\emailServiceSpring")
                .filename(".env")
                .load();

        AwsBasicCredentials awsCreds = AwsBasicCredentials.create(
                dotenv.get("AWS_ACCESS_KEY_ID"),
                dotenv.get("AWS_SECRET_ACCESS_KEY")
        );

        return SesV2Client.builder()
                .region(Region.of(dotenv.get("AWS_REGION")))
                .credentialsProvider(StaticCredentialsProvider.create(awsCreds))
                .build();
    }
}
