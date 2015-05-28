package weChat.web.advice;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import weChat.core.exception.ValidationErrorException;
import weChat.core.web.ErrorMsg;
import weChat.parameter.IRespParam;
import weChat.service.RespService;
import weChat.utils.RespMsgCode;

//Target all Controllers annotated with @RestController
@ControllerAdvice(annotations = RestController.class)
public class AnnotationAdvice {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private RespService respService;
	
	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<Object> handlerRuntimeException(Exception ex,
			WebRequest request) {
		logger.error("系统出现错误", ex);
		String message = ex.getMessage();
		IRespParam error = respService.serverError(message);
		return handleExceptionInternal(error);
	}
	/**
	 * 参数校验出错
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler(value = { MethodArgumentNotValidException.class })
	public ResponseEntity<Object> handleValidException(MethodArgumentNotValidException ex, WebRequest request){
		BindingResult bindingResult = ex.getBindingResult();
		List<ObjectError> errorList = bindingResult.getAllErrors();
		String msg = "";
		for(ObjectError objectError : errorList){
			if(objectError instanceof FieldError){
				FieldError fieldError = (FieldError) objectError;
				msg = fieldError.getField() + ":" + fieldError.getDefaultMessage();
			}else{
				msg = objectError.getObjectName() +":" +  objectError.getDefaultMessage();
			}
		}
		IRespParam parameterError = respService.parameterError(msg);
		return handleExceptionInternal(parameterError);
		
	}
	/**
	 * 参数校验不通过
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler(value={ValidationErrorException.class})
	public ResponseEntity<Object> handlerValidationErrorException(ValidationErrorException ex, WebRequest request){
		String msg = ex.toString();
		IRespParam parameterError = respService.parameterError(msg);
		return handleExceptionInternal(parameterError);
	}
	protected ResponseEntity<Object> handleExceptionInternal(Object body) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Object>(body, headers, HttpStatus.OK);
	}
}