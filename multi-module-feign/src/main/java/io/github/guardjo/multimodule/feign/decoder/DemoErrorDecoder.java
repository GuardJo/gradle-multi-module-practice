package io.github.guardjo.multimodule.feign.decoder;

import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor(staticName = "create")
public class DemoErrorDecoder implements ErrorDecoder {
    private final static ErrorDecoder DEFAULT_DECODER = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        HttpStatus httpStatus = HttpStatus.resolve(response.status());

        if (httpStatus.equals(HttpStatus.NOT_FOUND)) {
            return new RuntimeException("Current API is Not Found");
        }

        return DEFAULT_DECODER.decode(methodKey, response);
    }
}
