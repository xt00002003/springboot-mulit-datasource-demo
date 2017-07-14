package com.dark;

import com.dark.entity.PmsCommodity;
import com.dark.entity.TmsDrivers;
import com.dark.service.first.PmsCommodityService;
import com.dark.service.second.TmsDriversService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMulitDatasourceDemoApplicationTests {

	@Autowired
	private PmsCommodityService pmsCommodityService;
	@Autowired
	private TmsDriversService tmsDriversService;

	@Test
	public void contextLoads() {
	}
	@Test
	public void selectCommodityById(){
		Long id=4270L;
		PmsCommodity pmsCommodity=pmsCommodityService.selectByPrimaryKey(id);
		Assert.assertNotNull(pmsCommodity);
	}
	@Test
	public void selectDriversById(){
		Long id=10L;
		TmsDrivers tmsDrivers=tmsDriversService.selectByPrimaryKey(id);
		Assert.assertNotNull(tmsDrivers);
	}

}
