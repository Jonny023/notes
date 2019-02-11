--------------------
零拷贝				|
--------------------
	# NIO 的"zero-copy(零拷贝)"功能,消除移动一个文件的内容从文件系统到网络堆栈的复制步骤

	# 直接传输一个文件的内容,没有执行的数据应用程序的处理
		// 获取 FileInputStream
		FileInputStream in = new FileInputStream(file); 

		// 创建一个新的 DefaultFileRegion 用于文件的完整长度
		FileRegion region = new DefaultFileRegion(in.getChannel(), 0, file.length()); 

		// 发送 DefaultFileRegion 并且注册一个 ChannelFutureListener
		channel.writeAndFlush(region).addListener(new ChannelFutureListener() { 
			@Override
			public void operationComplete(ChannelFuture future) throws Exception {
				// 处理发送失败
				if (!future.isSuccess()) {
					Throwable cause = future.cause(); 
				}
			}
		});


--------------------
分段传输			|
--------------------
	# 类库
		ChunkedInput
			ChunkedFile
				平台不支持 zero-copy 或者你需要转换数据,从文件中一块一块的获取数据
			ChunkedNioFile
				与 ChunkedFile 类似,处理使用了NIOFileChannel
			ChunkedStream
				从 InputStream 中一块一块的转移内容
			ChunkedNioStream
				从 ReadableByteChannel 中一块一块的转移内容
