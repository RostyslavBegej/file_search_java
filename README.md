# File Search (Java)

## Overview

File Search Java is a simple Java application designed to search for files within a specified directory based on a given file name or pattern. This tool is useful for quickly locating files in a directory structure without manually browsing through folders.

## Features

- **Recursive Search**: The application can search through directories and their subdirectories to find matching files.
- **Case-Insensitive Search**: The search is case-insensitive, making it easier to find files without worrying about exact case matching.
- **Pattern Matching**: Supports basic pattern matching using wildcards (e.g., `.txt`).

## Prerequisites

- **Java Development Kit (JDK)**: Ensure you have JDK 8 or later installed on your system.
- **Maven**: The project uses Maven for dependency management and building.

## Installation

1. **Clone the Repository**:
```bash
git clone https://github.com/RostyslavBegej/file_search_java.git
```
2. **Navigate to the Project Directory**:
```bash
cd file_search_java
```
3. **Build the Project**:
```bash
mvn clean install
```

## Example Output

```bash
👋 Welcome to the File Search Program!

This tool allows you to quickly and easily search for files on your system.
Simply enter the name or keyword of the file you're looking for,
and the program will scan your directories to find matching results.

Enter the directory from which to start the search: C:\
Search by (1) File Name or (2) Creation Date? Enter 1 or 2: 1
Enter the file name or keyword: .txt
Found file: *.txt

Search by (1) File Name or (2) Creation Date? Enter 1 or 2: 2
Enter the creation date (yyyy-MM-dd): 2025-02-09
File created on 2025-02-09: *.txt
```

## Requirements

- Java 8 or later

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

### Happy Coding! 🚀
