package pe.edu.cibertec.appfundamentosrest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.appfundamentosrest.service.FundamentosService;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/fundamentos")
public class FundamentosController {

    private final FundamentosService fundamentosService;

    @GetMapping("/ejercicio1")
    public ResponseEntity<String> Ejercicio1(){
        return new ResponseEntity<>("Hola Mundo Rest", HttpStatus.OK);
    }


    @GetMapping("/primo")
    public ResponseEntity<String> validarNumeroPrimo(@RequestParam int numero){
        return new ResponseEntity<>(fundamentosService.validarNumeroPrimo(numero), HttpStatus.OK);
    }

    @GetMapping("/factorial")
    public ResponseEntity<String> validarNumeroFactorial(@RequestParam int numero){
        return new ResponseEntity<>(fundamentosService.calcularFactorial(numero), HttpStatus.OK);
    }

    //localhost:8080/api/v1/fundamentos/fibonacci/5
    @GetMapping("/fibonnaci/{numero}")
    public ResponseEntity <List<Integer>> calcularFibonnaci(@PathVariable int numero){
        return new ResponseEntity<>(fundamentosService.calcularFibonnaci(numero), HttpStatus.OK);
    }

    //localhost:8080/api/v1/fundamentos/suma/5?numero2=10
    @GetMapping("/suma/{numero1}")
    public ResponseEntity<String> calcularSuma(@PathVariable int numero1, @RequestParam int numero2){
        return new ResponseEntity<>(String.valueOf(numero1+numero2), HttpStatus.OK);
    }


    @GetMapping({"/hola", "hola/{nombre}"})
    public ResponseEntity<String> hola(@PathVariable(required = false) String nombre){
        if(nombre == null){
            return new ResponseEntity<>("Hola Mundo Rest", HttpStatus.OK);
        }
        return new ResponseEntity<>("hola "+nombre, HttpStatus.OK);
    }

}
