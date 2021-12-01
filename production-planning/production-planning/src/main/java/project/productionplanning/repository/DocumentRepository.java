package project.productionplanning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import project.productionplanning.model.Document;

public interface DocumentRepository extends JpaRepository<Document, Integer> {
}
