package rating;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hotel.rating.HotelRatingServiceApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HotelRatingServiceApplication.class)
@WebAppConfiguration
public class HotelRatingServiceApplicationTests {

	@Test
	public void contextLoads() {
	}

}
