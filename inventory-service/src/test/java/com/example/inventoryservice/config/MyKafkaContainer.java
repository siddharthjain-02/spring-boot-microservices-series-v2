/* Licensed under Apache-2.0 2023 */
package com.example.inventoryservice.config;

import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.utility.DockerImageName;

public interface MyKafkaContainer {

    @Container @ServiceConnection
    KafkaContainer KAFKA_CONTAINER =
            new KafkaContainer(DockerImageName.parse("confluentinc/cp-kafka").withTag("7.4.0"))
                    .withKraft();
}
