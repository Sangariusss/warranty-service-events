# Warranty Service Event System

## Table of Contents

- [Overview](#overview)
- [Technologies](#technologies)
- [Features](#features)
- [File Structure](#file-structure)
- [Setup](#setup)
- [Usage](#usage)
- [Contributions](#contributions)
- [License](#license)

## Overview

This project is a simple domain-driven event system for a warranty service in an electronics store. It demonstrates the use of domain events to handle business processes such as warranty activation and warranty claim submission. The project highlights core software engineering principles for handling domain events in Java.

## Technologies

- **Java 21**: Core programming language for the system.
- **SLF4J**: Simple Logging Facade for Java for log management.
- **Logback**: A logging framework for managing application logs.
- **Maven**: Dependency management and build tool.

## Features

- **Domain Event Publishing**: Mechanism to trigger and manage domain events.
- **Event Handlers (Implicit)**: Handles actions such as warranty activation and claim submission.
- **Event Types**: Two primary domain events implemented.
    - **WarrantyActivatedEvent**: Triggered when a warranty is activated.
    - **WarrantyClaimSubmittedEvent**: Triggered when a warranty claim is submitted.
- **Aggregate Management**: Business logic encapsulated within the `WarrantyService` aggregate.
- **Logging Support**: Provides structured logging using SLF4J and Logback.

## File Structure

```
src/main/java/com/sangarius/
├── aggregates/                # Aggregate for managing business logic
│   └── WarrantyService.java
├── events/                     # Domain event definitions
│   ├── DomainEvent.java
│   ├── WarrantyActivatedEvent.java
│   └── WarrantyClaimSubmittedEvent.java
├── services/                   # Domain event publisher
│   └── DomainEventPublisher.java
└── WarrantyServiceDemo.java    # Main demo class
pom.xml                         # Maven configuration file
```

## Setup

1. **Clone the repository:**
   ```bash
   git clone https://github.com/sangariusss/warranty-service-events.git
   cd warranty-service-events
   ```

2. **Build the project:**
   ```bash
   mvn clean install
   ```

3. **Run the demo:**
   ```bash
   mvn exec:java -Dexec.mainClass="com.sangarius.WarrantyServiceDemo"
   ```

## Usage

1. **Warranty Activation:**
    - The system will log a warranty activation event upon invoking `activateWarranty` in `WarrantyService`.

2. **Warranty Claim Submission:**
    - The system will log a warranty claim submission event upon invoking `submitClaim` in `WarrantyService`.

### Example Console Output:
```
INFO: Event published: WarrantyActivatedEvent (timestamp: 2025-02-08T17:39:04.120)
INFO: -> Generating electronic warranty certificate for product ID: P12345 (warranty ID: W98765)
INFO: Warranty activated for product ID: P12345
----------------------------------------
INFO: Event published: WarrantyClaimSubmittedEvent (timestamp: 2025-02-08T17:39:04.130)
INFO: -> Sending warranty claim request for product ID: P12345 (claim ID: C54321)
INFO: Warranty claim submitted for product ID: P12345 with claim ID: C54321
```

## Contributions

Contributions are welcome! If you'd like to add features or fix issues, please open a pull request or file an issue.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.