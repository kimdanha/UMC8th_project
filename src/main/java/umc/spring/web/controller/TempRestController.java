package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.TempConverter;
import umc.spring.service.TempService.TempQueryService;
import umc.spring.web.dto.TempResponse;

@RestController
@RequestMapping("/temp")
@RequiredArgsConstructor
public class TempRestController {

    private final TempQueryService tempQueryService;

    @GetMapping("/test")
    public ApiResponse<TempResponse.TempTestDTO> testAPI(@RequestParam("flag") Integer flag){

        return ApiResponse.onSuccess(TempConverter.toTempTestDTO(flag));
    }

    @GetMapping("/exception")
    public ApiResponse<TempResponse.TempExceptionDTO> exceptionAPI(@RequestParam("flag") Integer flag){
        tempQueryService.CheckFlag(flag);
        return ApiResponse.onSuccess(TempConverter.toTempExceptionDTO(flag));
    }

    @GetMapping("/error")
    public ApiResponse<String> errorAPI() {
        int result = 10 / 0; // 여기서 ArithmeticException 발생
        return ApiResponse.onSuccess("This will not be returned");
    }
}
