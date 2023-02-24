package com.project.swp.repository;

import com.project.swp.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MenuRepo extends JpaRepository<Menu, Integer> {

    @Query("select m from Menu m join Invoice i on m.foodId=i.invoiceID.menu.foodId " +
            "group by m.foodId order by sum (i.actualQuantity) desc limit 10")
    List<Menu> FindListHotFood();
}
