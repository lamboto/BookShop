package bookstore.web.filters;

import bookstore.domain.servicemodels.CategoryServiceModel;
import bookstore.domain.view.ListAllCategoryViewModel;
import bookstore.service.impl.CategoryServiceImpl;
import config.Mapper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebFilter("/*")
public class CommonFilter implements Filter {

    private final CategoryServiceImpl categoryService;
    private final Mapper mapper;

    public CommonFilter() {
        this.categoryService = new CategoryServiceImpl();
        mapper = new Mapper();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        List<CategoryServiceModel> categoryServiceModel = categoryService.findALl();

        List<ListAllCategoryViewModel> categoryViewModels = categoryServiceModel.stream()
                .map(e -> this.mapper.map(e, ListAllCategoryViewModel.class))
                .collect(Collectors.toList());

        request.setAttribute("allCategories", categoryViewModels);

        System.out.println("Common filter->doFilter");

        chain.doFilter(request, response);
    }
}
