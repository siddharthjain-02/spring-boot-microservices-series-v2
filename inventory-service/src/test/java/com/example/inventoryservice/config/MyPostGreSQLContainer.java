/* Licensed under Apache-2.0 2023 */
package com.example.inventoryservice.config;

import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.utility.DockerImageName;

public interface MyPostGreSQLContainer {

    @Container @ServiceConnection
    PostgreSQLContainer<?> POSTGRE_SQL_CONTAINER =
            new PostgreSQLContainer<>(DockerImageName.parse("postgres").withTag("15.3-alpine"));
}
