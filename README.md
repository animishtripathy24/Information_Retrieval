# Information Retrieval Project

This project implements various Information Retrieval (IR) techniques using Java programming. It covers fundamental concepts and methods such as tokenization, bigram indexing, cosine similarity, inverted indexing, and more. This project is part of the Information Retrieval subject.

## Project Structure

- `BigramIndexing.java`: Java class for bigram indexing.
- `CosineSimilarity.java`: Java class for computing cosine similarity between documents.
- `Edit_Distance.cpp`: C++ implementation for computing edit distance (not in Java).
- `Edit_Distance.exe`: Executable for the edit distance C++ implementation.
- `InformationRetrieval.java`: Main Java class for running various IR techniques.
- `InvertedIndexing.java`: Java class for creating and managing an inverted index.
- `KGramOverlap.java`: Java class for K-gram overlap computation.
- `MeanAveragePrecision.java`: Java class for computing mean average precision.
- `NormalisedDiscountedCummulativeGain.java`: Java class for normalized discounted cumulative gain (nDCG).
- `SkipPointers.java`: Java class for implementing skip pointers in indexing.
- `Tokenisation.java`: Java class for tokenizing documents.

## Features and Modules

### Tokenization
- **File**: `Tokenisation.java`
- **Description**: Tokenizes a set of documents into individual terms for further processing.

### Bigram Indexing
- **File**: `BigramIndexing.java`
- **Description**: Creates bigram indices for a set of documents, which helps in identifying common word pairs.

### Inverted Indexing
- **File**: `InvertedIndexing.java`
- **Description**: Creates an inverted index, mapping terms to the documents they appear in. This is essential for efficient search and retrieval.

### Cosine Similarity
- **File**: `CosineSimilarity.java`
- **Description**: Calculates the cosine similarity between documents, measuring the cosine of the angle between two non-zero vectors in a multi-dimensional space.

### K-Gram Overlap
- **File**: `KGramOverlap.java`
- **Description**: Computes the overlap of K-grams (substrings of length K) between documents.

### Mean Average Precision (MAP)
- **File**: `MeanAveragePrecision.java`
- **Description**: Calculates the mean average precision, a measure of the accuracy of the retrieved documents.

### Normalized Discounted Cumulative Gain (nDCG)
- **File**: `NormalisedDiscountedCummulativeGain.java`
- **Description**: Computes nDCG, which evaluates the usefulness, or gain, of a document based on its position in the result list.

### Skip Pointers
- **File**: `SkipPointers.java`
- **Description**: Implements skip pointers in an inverted index to allow faster query processing by skipping over non-relevant documents.

### Edit Distance (Implemented in C++)
- **File**: `Edit_Distance.cpp`
- **Description**: Computes the edit distance between two strings, measuring how many operations (insertions, deletions, updations) are required to transform one string into another.
## Conclusion

This project provides a comprehensive overview of various Information Retrieval techniques and algorithms. By implementing these methods in Java, we have demonstrated their practical applications in indexing, similarity computation, and relevance ranking.

## Future Processing

While the current implementation covers several essential IR concepts, there are opportunities for further enhancement and expansion:
- **Extension of Algorithms**: Implement additional IR algorithms such as Latent Semantic Indexing (LSI), PageRank, or clustering methods.
- **Integration with External Tools**: Integrate the project with external libraries or tools like Apache Lucene for advanced indexing and search capabilities.
- **User Interface Development**: Develop a user-friendly interface to interact with the IR system, enabling users to perform queries and visualize results effectively.
- **Optimization and Scalability**: Optimize algorithms for efficiency and scalability, especially for handling large datasets and real-time queries.
