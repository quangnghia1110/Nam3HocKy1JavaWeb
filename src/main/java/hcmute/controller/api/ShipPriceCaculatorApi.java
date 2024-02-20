package hcmute.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("api")
public class ShipPriceCaculatorApi {
	
	@GetMapping("/calculateDistance")
	public ResponseEntity<Object> calculateDistance(@RequestParam String origins, @RequestParam String destinations,
			@RequestParam String units) {
		String apiKey = "AIzaSyCMohr_wpjKEczE-IhEl-BGyXkeIEUFptw";
		String url = String.format(
				"https://maps.googleapis.com/maps/api/distancematrix/json?origins=%s&destinations=%s&units=%s&key=%s",
				origins, destinations, units, apiKey);

		RestTemplate restTemplate = new RestTemplate();
		Object response = restTemplate.getForObject(url, Object.class);

		return ResponseEntity.ok().body(response);
	}
}
