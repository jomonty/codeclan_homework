package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ActiveProfiles("test") //Indicates it's a test profile so will not run DataLoader
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	private DistilleryRepository distRepo;
	@Autowired
	private WhiskyRepository whiskyRepo;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canGetDistilleriesWithWhiskiesThatAre12YearsOld() {
		List<Distillery> distilleries = distRepo.findByWhiskiesAgeEquals(12);
		assertEquals(6, distilleries.size());
	}

	@Test
	public void canGetDistilleriesByRegionEquals() {
		List<Distillery> distilleries = distRepo.findByRegionEquals("Highland");
		assertEquals(3, distilleries.size());
		assertEquals("Highland", distilleries.get(0).getRegion());
	}

	@Test
	public void canGetAllWhiskyFromDistilleryOfSpecificAge() {
		List<Whisky> whiskies = whiskyRepo.findByAgeAndDistilleryName(12, "Glendronach");
		assertEquals(1, whiskies.size());
		assertEquals("The Glendronach Original", whiskies.get(0).getName());
	}

	@Test
	public void canGetAllWhiskiesOfAParticularYear() {
		List<Whisky> whiskies1987 = whiskyRepo.findByYearEquals(1987);
		assertEquals(1, whiskies1987.size());
		assertEquals("Glenkinchie 10", whiskies1987.get(0).getName());
		List<Whisky> whiskies2014 = whiskyRepo.findByYearEquals(2014);
		assertEquals(4, whiskies2014.size());
	}

	@Test
	public void canGetAllWhiskiesFromARegion() {
		List<Whisky> whiskies = whiskyRepo.findByDistilleryRegion("Island");
		assertEquals(6, whiskies.size());
		assertEquals("Viking Honour", whiskies.get(0).getName());
	}
}
