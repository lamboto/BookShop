package bookstore.service.impl;

import bookstore.domain.entitites.Category;
import bookstore.domain.servicemodels.CategoryServiceModel;
import bookstore.repository.CategoryRepository;
import bookstore.service.CategoryService;
import config.Mapper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.stream.Collectors;

public class CategoryServiceImpl implements CategoryService {

    private final EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;
    private final CategoryRepository categoryRepository;
    private final Mapper mapper = new Mapper();
    private final ValidationServiceImpl validationService = new ValidationServiceImpl();

    public CategoryServiceImpl() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("book_shop");
        this.entityManager = entityManagerFactory.createEntityManager();
        this.categoryRepository = new CategoryRepository(entityManager);
    }

    @Override
    public List<CategoryServiceModel> findALl() {
        return this.categoryRepository.listAll().stream()
                .map(e -> this.mapper.map(e, CategoryServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void createCategory(String name) throws Exception {
        if (this.validationService.canCreateUser(name)) {

            CategoryServiceModel categoryServiceModel = new CategoryServiceModel();
            categoryServiceModel.setName(name);
            this.categoryRepository.create(this.mapper.map(categoryServiceModel, Category.class));
        } else {
            throw new Exception("User cannot be created");
        }
    }

    @Override
    public void delete(int id) throws Exception {
        if (validationService.isCategoryValid(id)){
            this.categoryRepository.delete(id);
        }else {
            throw new Exception("Category cannot be deleted");
        }
    }

    @Override
    public void updateCategory(int id, String name) throws Exception {
        if (this.validationService.canCreateUser(name)) {
            CategoryServiceModel categoryServiceModel = new CategoryServiceModel();
            categoryServiceModel.setCategoryId(id);
            categoryServiceModel.setName(name);
            this.categoryRepository.update(this.mapper.map(categoryServiceModel, Category.class));
        }else {
            throw new Exception("User cannot be updated");
        }
    }

    @Override
    public Category findCategoryByName(String name) {
        return this.categoryRepository.findCategoryByName(name);
    }

    @Override
    public Category getById(int id) {
        return this.categoryRepository.get(id);
    }
}
