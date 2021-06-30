package bookstore.domain.view;

public class ListAllCategoryViewModel {
    private int categoryId;
    private String name;

    public ListAllCategoryViewModel() {
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
