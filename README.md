# Java Socket Programming – Server Concurrency Models

This project demonstrates different server-side concurrency architectures using Java socket programming.

## Implementations
- Single-threaded server
- Multi-threaded server (thread-per-client)
- Thread pool server using ExecutorService

## Performance Testing
- Load tested using Apache JMeter
- ~60,000 total requests
- ~1000 requests per second
- Compared response time, deviation, and throughput

## Project Structure
SingleThreaded/  – Sequential server  
MultiThreaded/   – Thread-per-client server  
ThreadPool/      – ExecutorService-based server  
docs/            – Project documentation (PDF)

## Author
Naman Chotai
