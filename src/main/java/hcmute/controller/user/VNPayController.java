package hcmute.controller.user;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import hcmute.config.VNPayConfig;


@Controller
@RequestMapping("api/payment")
public class VNPayController {

	public static String dataOrder; 
	
	@GetMapping("/create_payment")
	public String createPayment(@RequestParam("cost") Long cost, @RequestParam("data") String data) throws UnsupportedEncodingException {
		String vnp_Version = "2.1.0";
		String vnp_Command = "pay";
		String vnp_TxnRef = VNPayConfig.getRandomNumber(8);
		String vnp_IpAddr = "127.0.0.1";
		String vnp_TmnCode = VNPayConfig.vnp_TmnCode;
		String orderType = "order-type";
		
		Map<String, String> vnp_Params = new HashMap<>();
		vnp_Params.put("vnp_Version", vnp_Version);
		vnp_Params.put("vnp_Command", vnp_Command);
		vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
		vnp_Params.put("vnp_Amount", String.valueOf(cost * 100));
		vnp_Params.put("vnp_CurrCode", "VND");

		vnp_Params.put("vnp_TxnRef", vnp_TxnRef);
		vnp_Params.put("vnp_OrderInfo", "OK");
		vnp_Params.put("vnp_OrderType", orderType);

		String locate = "vn";
		vnp_Params.put("vnp_Locale", locate);

		String urlReturn = VNPayConfig.vnp_ReturnUrl;
		dataOrder = encodeData(data);
		
		vnp_Params.put("vnp_ReturnUrl", urlReturn);
		vnp_Params.put("vnp_IpAddr", vnp_IpAddr);
		Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String vnp_CreateDate = formatter.format(cld.getTime());
		vnp_Params.put("vnp_CreateDate", vnp_CreateDate);

		cld.add(Calendar.MINUTE, 15);
		String vnp_ExpireDate = formatter.format(cld.getTime());
		vnp_Params.put("vnp_ExpireDate", vnp_ExpireDate);

		List fieldNames = new ArrayList(vnp_Params.keySet());
		Collections.sort(fieldNames);
		StringBuilder hashData = new StringBuilder();
		StringBuilder query = new StringBuilder();
		Iterator itr = fieldNames.iterator();
		while (itr.hasNext()) {
			String fieldName = (String) itr.next();
			String fieldValue = (String) vnp_Params.get(fieldName);
			if ((fieldValue != null) && (fieldValue.length() > 0)) {
				// Build hash data
				hashData.append(fieldName);
				hashData.append('=');
				try {
					hashData.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
					// Build query
					query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString()));
					query.append('=');
					query.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				if (itr.hasNext()) {
					query.append('&');
					hashData.append('&');
				}
			}
		}
		
		String queryUrl = query.toString();
		String vnp_SecureHash = VNPayConfig.hmacSHA512(VNPayConfig.secretKey, hashData.toString());
		queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;
		String paymentUrl = VNPayConfig.vnp_PayUrl + "?" + queryUrl;
		return "redirect:" + paymentUrl;
	}
	
	@GetMapping("/transaction")
	public String checkTransaction(ModelMap model, @RequestParam("vnp_ResponseCode") String responseCode)
	{
		if(responseCode.equals("00"))
		{
			//Giao dịch thành công, lưu thông tin đơn hàng
			return "redirect:http://localhost:8989/payment/order?data=" + dataOrder;
		}
		else
		{
			//Giao dịch không thành công, chuyển về trang cart
			model.addAttribute("message", "Thanh toán không thành công!");
			model.addAttribute("status", "fail");
			// Viết dùm thông báo hiển thị cartMessage ở cart.jsp
			return "user/cart";
		}
	}

	private static String encodeData(String data) throws UnsupportedEncodingException {
		return URLEncoder.encode(data, StandardCharsets.UTF_8.toString());
	}
}
