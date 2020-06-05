--------------------------------
SpringBoot
--------------------------------
	# 依赖
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-validation</artifactId>
		</dependency>
	
	# 在 Controller 的方法上，对形参对象添加 @Validated 注解
		
		@Target({ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER})
		@Retention(RetentionPolicy.RUNTIME)
		@Documented
		public @interface Validated {
			Class<?>[] value() default {};  // 通过valu指定要执行校验的Group
		}

		* 形参对象，一定要给上 getter/setter 方法
	

	# 通过捕获 BindException 处理校验的异常信息
		* 在 @Validated 参数后面，声明一个：BindingResult bindingResult 对象
		* 通过这个对象，来判断是否有异常，以及获取到异常的信息

		@GetMapping
		public Object test ( @Validated  User user, BindingResult bindingResult) {
			if (bindingResult.hasErrors()) {
				// 获取到异常对象
				List<ObjectError> objectErrors = bindingResult.getAllErrors();
				// 获取到默认的提示信息
				List<String> errorMessages = objectErrors.stream().map(ObjectError::getDefaultMessage).collect(Collectors.toList());
				return errorMessages;
			}
			return Message.success(user);
		}
	
	# 通过全局异常处理器，处理校验的异常信息
		* 如果没有定义 BindingResult ，那么在校验失败的时候会抛出异常
		* 捕获异常: BindException/MethodArgumentNotValidException 
			@ExceptionHandler(value = {
				BindException.class
			})
			public Object validateFail(HttpServletRequest request, HttpServletResponse response, BindException e)
					throws IOException {
				String errorMessage = e.getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.joining("|"));
				return this.errorHandler(request, response, Message.fail(Message.Code.BAD_REQUEST, errorMessage), e);
			}
	
	# 声明式参数校验
		@GetMapping("/get")
		public RspDTO getUser(@RequestParam("userId") @NotNull(message = "用户id不能为空") Long userId) {
			User user = userService.selectById(userId);
			if (user == null) {
				return new RspDTO<User>().nonAbsent("用户不存在");
			}
			return new RspDTO<User>().success(user);
		}
