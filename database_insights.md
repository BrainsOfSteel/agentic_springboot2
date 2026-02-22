# Agent Skills: Database Interaction & Bench Analytics

## Overview
This agent is designed to interact with **Database [Y]** and analyze data from **Table [X]**.  
Table [X] contains a `bench_id` field and supports generating aggregated counts per bench, including chart visualization.

---

## Core Capabilities

### 1. Database Connectivity
- Connect to Database (SQL Server -> running on localhost:1433, database name : gem_database)
- Authenticate using secure credentials -> ask for login name and password
- Handle connection pooling and retries
- Gracefully manage connection errors

### 2. Table [X] Data Access
- Read records from Table name -> voyages
- Extract `bench` values
- Perform filtered queries (date range, status, etc. if applicable)
- Support pagination for large datasets

---

## Data Aggregation Skills

### Count Records Per Bench
The agent can:

- Group records by `bench_id`
- Calculate total count per bench
- Sort results (ascending/descending)
- Return results in structured format (JSON/table)

#### Example SQL Query
```sql
SELECT bench_id, COUNT(*) AS total_count
FROM X
GROUP BY bench_id
ORDER BY total_count DESC;
```
If the sql does not work, then use the following web - API
and RUN it through default browser 
http://localhost:8080/voyages/distinctCountByBenches
Schema of response (example)
{
	"benchId1": 13900,
	"benchId2": 3050000,
	"benchId3": 1050000,
}

#### Chart Generation Capability
The agent can generate visual representations of bench counts:
Supported Chart Types
    Bar Chart (default)
    Pie Chart
    Line Chart (if time-based data exists)
    Chart Features
        X-axis: bench_id
        Y-axis: Count of records
    Configurable:
        Title
        Labels
        Color schemes
        Export format (PNG, JPG, SVG)
