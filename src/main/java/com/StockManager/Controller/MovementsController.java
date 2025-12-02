package com.StockManager.Controller;

import java.util.List;
import java.util.Optional;

import com.StockManager.Model.HandlingType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.StockManager.Model.DTO.MovementDTO;
import com.StockManager.Services.MovementsService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/moviments")
public class MovementsController {

	@Autowired
	private MovementsService mService;
	
	@GetMapping()
	public List<MovementDTO> findAllMoviments() {
		return mService.findAll();
	}
	
	@GetMapping("/{id}")
	public MovementDTO findMovement(@RequestParam Long id) {
		return mService.findById(id);
	}

	@GetMapping("/type/{type}")
	public ResponseEntity<List<MovementDTO>> findType(@PathVariable String type){
		try {
			HandlingType handlingType = HandlingType.valueOf(type.toUpperCase());
			List<MovementDTO> result = mService.findByType(handlingType.name());
			return ResponseEntity.ok(result);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@PostMapping()
	public MovementDTO createMovement(@RequestBody MovementDTO dto) {
		return mService.create(dto);
	}
	
	/*@PutMapping()
	public MovementDTO putMovement(MovementDTO dto) {
		return mService.update(dto);
	}*/
	
	@DeleteMapping("/{id}")
	public void deleteMovement(@RequestParam Long id){
		mService.delete(id);
	}
}
