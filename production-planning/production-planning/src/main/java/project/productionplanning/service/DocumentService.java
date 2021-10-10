package project.productionplanning.service;

import project.productionplanning.dto.DocumentDto;

import java.util.List;

public interface DocumentService {
    List<DocumentDto> getAllDocuments();
    DocumentDto getDocumentById(Integer id);
    DocumentDto addDocument(DocumentDto documentDto);
    DocumentDto updateDocument(DocumentDto documentDto, Integer id);
    void deleteDocument(Integer id);
}
