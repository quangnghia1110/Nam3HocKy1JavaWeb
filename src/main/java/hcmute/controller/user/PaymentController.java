package hcmute.controller.user;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import hcmute.embeddedId.OrderDetailId;
import hcmute.entity.BranchEntity;
import hcmute.entity.MilkTeaEntity;
import hcmute.entity.OrderDetailEntity;
import hcmute.entity.OrderEntity;
import hcmute.entity.PayMethodEntity;
import hcmute.entity.UserEntity;
import hcmute.model.MilkTeaModel;
import hcmute.model.OrderData;
import hcmute.model.OrderModel;
import hcmute.model.OrderProduct;
import hcmute.model.OrderProduct.OrderItem;
import hcmute.service.IBranchService;
import hcmute.service.IMilkTeaService;
import hcmute.service.IOrderDetailService;
import hcmute.service.IOrderService;
import hcmute.service.IPayMethodService;
import hcmute.service.IUserService;
import hcmute.service.impl.CookieServiceImpl;

@Controller
@RequestMapping("payment")
public class PaymentController {
	@Autowired
	IOrderService orderService;

	@Autowired
	IOrderDetailService orderDetailService;

	@Autowired
	IUserService userService;

	@Autowired
	IPayMethodService payMethodService;

	@Autowired
	IMilkTeaService milkTeaService;
	
	@Autowired
	IBranchService branchService;
	
	@Autowired
	CookieServiceImpl cookieServiceImpl;

	@GetMapping("")
	private String displayPayment(ModelMap model, @RequestParam("data") String data, @RequestParam("listBranch") String listBranch)
			throws UnsupportedEncodingException {
//		data = URLDecoder.decode(data, "UTF-8");
		byte[] decodedBytes = Base64.getDecoder().decode(data);
		data = new String(decodedBytes, StandardCharsets.UTF_8);
		model.addAttribute("dataJSON", data);
		List<PayMethodEntity> listPayMethod = payMethodService.findAll();
		model.addAttribute("listPayMethod", listPayMethod);
		int idUser = Integer.parseInt(cookieServiceImpl.getValue("USER_ID"));
		Optional<UserEntity> optCustomer = userService.findById(idUser);
		if (optCustomer.isPresent()) {
			UserEntity customer = optCustomer.get();
			model.addAttribute("customer", customer);
		}
		
		byte[] branchBytes = Base64.getDecoder().decode(listBranch);
		String branchString = new String(branchBytes);
		branchString = branchString.trim();
		if (branchString.startsWith("[")) {
			branchString = branchString.substring(1, branchString.length() - 1);
        }
		
		List<String> branchList = new ArrayList<>(Arrays.asList(branchString.split(",")));
		List<BranchEntity> branches = new ArrayList<BranchEntity>();
		for(String branchId : branchList) {
			int id = Integer.parseInt(branchId);
			Optional<BranchEntity> opt = branchService.findById(id);
			if(opt.isPresent()) {
				branches.add(opt.get());
			}
		}
		model.addAttribute("branches", branches);
		
		ObjectMapper objectMapper = new ObjectMapper();

		try {
			OrderProduct orderProduct = objectMapper.readValue(data, OrderProduct.class);
			List<MilkTeaModel> listMilkTea = new ArrayList<MilkTeaModel>();
			for (OrderItem item : orderProduct.getList()) {
				Optional<MilkTeaEntity> entity = milkTeaService.findByIdMilkTea(Integer.parseInt(item.getIdMilkTea()));
				if (entity.isPresent()) {
					MilkTeaModel milkTeaModel = new MilkTeaModel();
					BeanUtils.copyProperties(entity.get(), milkTeaModel);
					milkTeaModel.setSize(item.getSize());
					milkTeaModel.setOrderQuantity(Integer.parseInt(item.getQuantity()));
					milkTeaModel.setCost(item.getPrice());
					listMilkTea.add(milkTeaModel);
				}
			}
			model.addAttribute("orderProduct", orderProduct);
			model.addAttribute("listMilkTea", listMilkTea);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "user/payment";
	}

	@GetMapping("/order")
	private String insertOrder(ModelMap model, @RequestParam("data") String data)
			throws UnsupportedEncodingException, JsonMappingException, JsonProcessingException {
		int idUser = Integer.parseInt(cookieServiceImpl.getValue("USER_ID"));
		byte[] decodedBytes = Base64.getDecoder().decode(data);
		data = new String(decodedBytes, StandardCharsets.UTF_8);
		ObjectMapper objectMapper = new ObjectMapper();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		try {
			OrderData orderData = objectMapper.readValue(data, OrderData.class);
			OrderEntity orderEntity = new OrderEntity();
			orderEntity.setTotalProduct(orderData.getTotalProduct());
			orderEntity.setTotalPrice(orderData.getTotalPrice());
			orderEntity.setFinalPrice(orderData.getFinalPrice());
			LocalDateTime localDateTime = LocalDateTime.parse(orderData.getOrderDay(), formatter);
			orderEntity.setOrderDay(localDateTime.truncatedTo(ChronoUnit.SECONDS));
			orderEntity.setOrderState(orderData.getOrderState());
			localDateTime = LocalDateTime.parse(orderData.getShipDay(), formatter);
			orderEntity.setShipDay(localDateTime.truncatedTo(ChronoUnit.SECONDS));
			orderEntity.setNote(orderData.getNote());
			orderEntity.setAddress(orderData.getAddress());
			orderEntity.setPhoneNumber(orderData.getPhoneNumber());
			orderEntity.setFee(orderData.getFee());
			Optional<BranchEntity> optBranch = branchService.findById(orderData.getIdBranch());
			if(optBranch.isPresent()) {
				orderEntity.setBranchByOrder(optBranch.get());
			}

			if (orderData.getIdPayMethod() != null) {
				Optional<PayMethodEntity> payMethodOpt = payMethodService.findById(orderData.getIdPayMethod());
				if (payMethodOpt.isPresent()) {
					orderEntity.setPayMethodByOrder(payMethodOpt.get());
				}
			}

			Optional<UserEntity> optCustomer = userService.findById(idUser);
			if (optCustomer.isPresent()) {
				orderEntity.setCustomerByOrder(optCustomer.get());
			}
			orderService.save(orderEntity);

			for (OrderData.OrderItem item : orderData.getList()) {
				OrderDetailEntity orderDetailEntity = new OrderDetailEntity();
				orderDetailEntity.setQuantity(item.getQuantity());
//				orderDetailEntity.setCurrPrice(item.getPrice());

				Optional<MilkTeaEntity> milkTeaEntity = milkTeaService.findByIdMilkTea(item.getIdMilkTea());

				if (milkTeaEntity.isPresent()) {
					orderDetailEntity.setMilkTeaByOrderDetail(milkTeaEntity.get());
				}

				orderDetailEntity.setOrderByOrderDetail(orderEntity);

				OrderDetailId idOrderDetail = new OrderDetailId();
				idOrderDetail.setSize(item.getSize());
				idOrderDetail.setIdOrder(orderDetailEntity.getOrderByOrderDetail().getIdOrder());
				idOrderDetail.setIdMilkTea(orderDetailEntity.getMilkTeaByOrderDetail().getIdMilkTea());
				orderDetailEntity.setIdOrderDetail(idOrderDetail);

				orderDetailService.save(orderDetailEntity);
				model.addAttribute("orderMessage", "Bạn đã đặt hàng thành công!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "user/home";
	}
}