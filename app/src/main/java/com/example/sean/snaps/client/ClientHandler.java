package com.example.sean.snaps.client;
/*
 * Copyright 2012 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */


        import java.nio.charset.Charset;

        import io.netty.buffer.ByteBuf;
        import io.netty.buffer.Unpooled;
        import io.netty.channel.ChannelHandlerContext;
        import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Handler implementation for the echo client.  It initiates the ping-pong
 * traffic between the echo client and server by sending the first message to
 * the server.
 */
public class ClientHandler extends ChannelInboundHandlerAdapter {


    Object temp;

    public ClientHandler(Object msg){
        temp = msg;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {

        String sendMessage = (String)temp;

        ByteBuf messageBuffer = Unpooled.buffer();
        messageBuffer.writeBytes(sendMessage.getBytes());

        StringBuilder builder = new StringBuilder();
        builder.append("전송한 문자열[");
        builder.append(sendMessage);
        builder.append("]");

        System.out.println(builder.toString());

        ctx.writeAndFlush(messageBuffer);

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        String readMessage = ((ByteBuf) msg).toString(Charset.defaultCharset());

        StringBuilder builder = new StringBuilder();
        builder.append("수신한 문자열 [");
        builder.append(readMessage);
        builder.append("]");

        System.out.println(builder.toString());

        ClientEventMapper cem = new ClientEventMapper();
        cem.compareMessage(readMessage);
        ctx.write(msg);
    }



    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        System.out.println("수신 완료");
        channelClose(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }

    public void channelClose(ChannelHandlerContext ctx){
        System.out.println("Channel 종료");
        ctx.close();
    }
}