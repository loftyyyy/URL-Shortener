# Architecture Stack
- Spring Boot (4.1.1)
- PostgreSQL
- Redis
- Cache Abstraction

# API endpoints
- POST (http://localhost:8080/shorten)
- GET (http://localhost:8080/{shortenUrl})

# Performance and Load Testing (K6 Grafana)
- To validate the scalability and low-latency design of the Cache-Aside pattern, the service was stress-tested locally using **k6** under an escalating load profile (up to 200 concurrent virtual users).

## Benchmark Results (Summary)
* **Total Throughput:** **8,207.72 Requests / Second (RPS)**
* **Total Requests Handled:** **410,451 completed requests** with a **0.00% error rate**
* **p95 Latency:** **3.49ms** (95% of all redirect requests completed in under 3.5 milliseconds)
* **Median Latency:** **1.21ms**
> *The Redis memory caching layer successfully shielded PostgreSQL from heavy database locks, allowing consistent sub-5ms response times under spike traffic.*
 
<img width="931" height="827" alt="image" src="https://github.com/user-attachments/assets/ebf67289-4c59-478f-8881-09c67e509e50" />


# Patterns Used
- ## Cache-Aside Pattern for the caching layer
<img width="1056" height="635" alt="image" src="https://github.com/user-attachments/assets/215dcb3d-c943-4d1d-98f6-f23622911cf9" />









# Main System Design for the Caching Layer

<img width="1024" height="559" alt="image" src="https://github.com/user-attachments/assets/c5c210af-4de9-418d-b9d3-8b05cdc77ad9" />


# Future Works

## Create it's own Frontend UI and maybe deploy it
