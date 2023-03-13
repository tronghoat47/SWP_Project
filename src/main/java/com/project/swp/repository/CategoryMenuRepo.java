package com.project.swp.repository;

import com.project.swp.entity.CategoryMenu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryMenuRepo extends JpaRepository<CategoryMenu, Integer> {
    CategoryMenu findCategoryMenuByCateID(int cateID);
}
