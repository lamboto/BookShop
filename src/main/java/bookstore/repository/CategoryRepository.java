package bookstore.repository;

import bookstore.domain.entitites.Book;
import bookstore.domain.entitites.Category;


import javax.persistence.EntityManager;
import java.util.List;

public class CategoryRepository extends JpaRepository<Category> implements GenericRepository<Category> {

    public CategoryRepository() {

    }

    @Override
    public Category create(Category category) {
        return super.create(category);
    }

    @Override
    public Category update(Category category) {
        return super.update(category);
    }

    @Override
    public Category get(Object id) {
        return super.get(Category.class, id);
    }

    @Override
    public void delete(Object id) {
        super.delete(Category.class, id);
    }

    @Override
    public List<Category> listAll() {
        return super.listAll("Category.findAll");
    }

    @Override
    public long count() {
        return super.count("Category.count");
    }

    public Category findCategoryByName(String name) {
        List<Category> listCategories = super.findWithNamedQuery("Category.findByName", "name", name);
        if (listCategories != null && listCategories.size() > 0) {
            return listCategories.get(0);
        }
        return null;
    }
}
