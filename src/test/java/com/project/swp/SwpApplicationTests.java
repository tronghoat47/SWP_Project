package com.project.swp;

import com.project.swp.entity.CategoryMenu;
import com.project.swp.entity.Menu;
import com.project.swp.repository.CategoryMenuRepo;
import com.project.swp.repository.MenuRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@Rollback(value = false)
class SwpApplicationTests {

	@Autowired
	private MenuRepo menuRepo;

	@Test
	public void TestListAll(){
		Iterable<Menu>  menus = menuRepo.findAll();
		Assertions.assertThat(menus).hasSizeGreaterThan(0);
		for (Menu menu: menus) {
			System.out.println(menu.isStatusFood());
		}
	}

}
