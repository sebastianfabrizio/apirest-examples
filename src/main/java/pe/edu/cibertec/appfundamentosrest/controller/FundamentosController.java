package pe.edu.cibertec.appfundamentosrest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.appfundamentosrest.service.FundamentosService;

import java.math.BigDecimal;
import java.util.ArrayList;
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


    //localhost:8080/api/v1/fundamentos/hola
    //localhost:8080/api/v1/fundamentos/hola/sebas
    @GetMapping({"/hola", "hola/{nombre}"})
    public ResponseEntity<String> hola(@PathVariable(required = false) String nombre){
        if(nombre == null){
            return new ResponseEntity<>("Hola Mundo Rest", HttpStatus.OK);
        }
        return new ResponseEntity<>("hola "+nombre, HttpStatus.OK);
    }

    //localhost:8080/api/v1/fundamentos/potencia=?numero=8&exponente=3
    @GetMapping("/potencia")
    public ResponseEntity<String> potencia(@RequestParam(required = false,
            defaultValue = "2") int numero, @RequestParam(required = false,
            defaultValue = "2") int exponente){
        double valorPotencia = Math.pow(numero, exponente);
        return new ResponseEntity<>("El resultado es ="+ valorPotencia, HttpStatus.OK);
    }

    @GetMapping({"/generar", "generar/{inicio}"})
    public ResponseEntity<List<Integer>> generar(  @PathVariable(required = false) Integer inicio,
                                                   @RequestParam(required = false, defaultValue = "10") Integer fin){
      if(inicio == null){
          inicio = 1;
      }
      List<Integer> rango = new ArrayList<>();
      for(int i = inicio; i <=fin; i++){
          rango.add(i);
      }
      return new ResponseEntity<>(rango, HttpStatus.OK);
    }

}
