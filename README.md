# Java Socket Programming – Server Concurrency Models

This project demonstrates three different server-side concurrency models in Java socket programming:

- **Single-threaded server** (sequential request handling)
- **Multi-threaded server** (one thread per client connection)
- **Thread pool server** (using `ExecutorService` for efficient thread management)

The goal is to illustrate the trade-offs between simplicity, resource usage, and scalability when handling multiple concurrent client connections.

## Project Structure

```
JAVA-SOCKET-CONCURRENCY/
│
├── docs/
│   └── Java_Socket_Programming.pdf          # Detailed project documentation
│
├── MultiThreaded/
│   ├── Client.java
│   └── Server.java                           # Thread-per-client implementation
│
├── SingleThreaded/
│   ├── Client.java
│   └── Server.java                           # Sequential single-threaded server
│
└── ThreadPool/
    └── Server.java                           # ExecutorService-based thread pool server
```

> **Note**: Client code is provided in `SingleThreaded/` and `MultiThreaded/` directories for testing. The thread pool server is compatible with either client.

## Concurrency Models Implemented

| Model              | Directory         | Description                                                                 | Pros                              | Cons                                      |
|--------------------|-------------------|-----------------------------------------------------------------------------|-----------------------------------|-------------------------------------------|
| Single-Threaded    | `SingleThreaded/` | Handles one client at a time sequentially                                   | Simple, low resource usage        | Poor scalability, blocks on slow clients   |
| Multi-Threaded     | `MultiThreaded/`  | Spawns a new thread for each incoming client connection                     | Good responsiveness               | High resource overhead with many clients  |
| Thread Pool        | `ThreadPool/`     | Uses a fixed-size thread pool via `ExecutorService` to handle connections   | Balanced performance & resources   | Slightly more complex configuration       |

## Performance Testing

The servers were load-tested using **Apache JMeter** with the following parameters:

- **Total requests**: ~60,000
- **Request rate**: ~1,000 requests per second
- **Metrics compared**:
  - Average response time
  - Standard deviation
  - Throughput
  - Error rate

Results showed that the **thread pool model** offers the best balance of performance and resource efficiency under high load, while the single-threaded server struggles with concurrency and the thread-per-client model consumes excessive threads/memory.

Detailed results and graphs are available in the documentation PDF.

## How to Run

1. Compile the server and client:
   ```bash
   javac SingleThreaded/Server.java SingleThreaded/Client.java
   # or similarly for MultiThreaded/
   ```

2. Start the server in one terminal:
   ```bash
   java SingleThreaded.Server
   ```

3. Run multiple clients in separate terminals or use JMeter for load testing:
   ```bash
   java SingleThreaded.Client
   ```

The servers listen on port `8080` by default (configurable in source).

## Requirements

- Java 8 or higher
- Apache JMeter (optional, for performance testing)

## Author

Naman Chotai  
© 2025

## Documentation

For in-depth explanations, code walkthroughs, performance analysis, and diagrams, refer to:

[docs/Java_Socket_Programming.pdf](./docs/Java_Socket_Programming.pdf)
