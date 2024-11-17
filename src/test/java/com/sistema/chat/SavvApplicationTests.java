/*
package com.sistema.chat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import java.lang.reflect.Type;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ChatApplicationTests {

	private static final String WEBSOCKET_URL = "ws://localhost:9098/chat-socket";
	private static final String SUBSCRIBE_TOPIC = "/topic/test-room";
	private static final String SEND_ENDPOINT = "/app/chat/test-room";

	private final BlockingQueue<String> blockingQueue = new LinkedBlockingDeque<>();

	@Autowired
	private WebSocketStompClient stompClient;

	@Test
	void contextLoads() throws Exception{
		StompSession session = stompClient
				.connect(WEBSOCKET_URL, new StompSessionHandlerAdapter() {})
				.get(1, TimeUnit.SECONDS);

		session.subscribe(SUBSCRIBE_TOPIC, new DefaultStompFrameHandler());

		String testMessage = "{\"message\":\"Hello, World!\",\"user\":\"Test User\"}";
		session.send(SEND_ENDPOINT, testMessage.getBytes());

		String receivedMessage = blockingQueue.poll(2, TimeUnit.SECONDS);
		assertThat(receivedMessage).isEqualTo(testMessage);
	}

	private class DefaultStompFrameHandler implements StompFrameHandler {
		@Override
		public Type getPayloadType(StompHeaders headers) {
			return String.class;
		}

		@Override
		public void handleFrame(StompHeaders headers, Object payload) {
			blockingQueue.offer(new String((byte[]) payload));
		}
	}
}
*/
