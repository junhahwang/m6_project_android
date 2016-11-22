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

        import io.netty.bootstrap.Bootstrap;
        import io.netty.buffer.ByteBuf;
        import io.netty.buffer.Unpooled;
        import io.netty.channel.Channel;
        import io.netty.channel.ChannelFuture;
        import io.netty.channel.ChannelInitializer;
        import io.netty.channel.ChannelOption;
        import io.netty.channel.ChannelPipeline;
        import io.netty.channel.EventLoopGroup;
        import io.netty.channel.nio.NioEventLoopGroup;
        import io.netty.channel.oio.OioEventLoopGroup;
        import io.netty.channel.socket.SocketChannel;
        import io.netty.channel.socket.nio.NioSocketChannel;
        import io.netty.channel.socket.oio.OioSocketChannel;
        import io.netty.handler.ssl.SslContext;
        import io.netty.handler.ssl.SslContextBuilder;
        import io.netty.handler.ssl.util.InsecureTrustManagerFactory;

/**
 * Sends one message when a connection is open and echoes back any received data
 * to the server. Simply put, the echo client initiates the ping-pong traffic
 * between the echo client and server by sending the first message to the
 * server.
 */
public class Client {

    static boolean SSL = System.getProperty("ssl") != null;
    static String HOST = System.getProperty("host", "127.0.0.1");
    static int PORT = Integer.parseInt(System.getProperty("port", "5555"));
    static int SIZE = Integer.parseInt(System.getProperty("size", "256"));


    public Client(String host, String port) {

        HOST = System.getProperty("host", host);
        PORT = Integer.parseInt(System.getProperty("port", port));


    }


    public void openConnection(Object msg) {
        // Configure SSL.git
        final Object temp = msg;

        System.out.println("전송 시작");

        EventLoopGroup group = new OioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group).channel(OioSocketChannel.class)

                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline p = ch.pipeline();

                            p.addLast(new ClientHandler(temp));
                        }
                    });

            // Start the client.
            ChannelFuture f = b.connect(HOST, PORT).sync();

            // Wait until the connection is closed.
            f.channel().closeFuture().sync();


        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            // Shut down the event loop to terminate all threads.
            group.shutdownGracefully();

        }
    }

}