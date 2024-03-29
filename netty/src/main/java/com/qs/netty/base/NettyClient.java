package com.qs.netty.base;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * netty client
 *
 * @author feishi
 * @date 2021/11/04
 */
public class NettyClient {
    public static void main(String[] args) throws Exception {
        // 客户端需要一个事件循环组
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            // 创建客户端启动对象
            // 注意客户端使用的不是ServerBootstrap而是Bootstrap
            Bootstrap bootstrap = new Bootstrap();
            // 设置相关参数
            // 设置线程组
            bootstrap.group(group)
                    // 使用NioSocketChannel作为客户端的通道实现
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            // 加入处理器
                            ch.pipeline().addLast(new NettyClientHandler());
                        }
                    });

            System.out.println("netty client start。。");
            // 启动客户端去连接服务器端
            ChannelFuture cf = bootstrap.connect("127.0.0.1", 9000).sync();
            // 对通道关闭进行监听
            cf.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }
    }
}