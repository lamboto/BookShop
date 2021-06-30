package bookstore.service;

import bookstore.domain.entitites.Category;
import bookstore.domain.entitites.User;
import bookstore.domain.servicemodels.CategoryServiceModel;
import bookstore.domain.servicemodels.UserServiceModel;

import java.util.List;

public interface CategoryService {

    List<CategoryServiceModel> findALl();

    void createCategory(String name) throws Exception;

    void delete(int id) throws Exception;

    void updateCategory(int id, String name) throws Exception;

   Category findCategoryByName(String name);


    Category getById(int id);
}
