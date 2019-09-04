import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

public class TestHttpserverHandler extends SimpleChannelInboundHandler {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {
        ByteBuf content = Unpooled.copiedBuffer("Hello World", CharsetUtil.UTF_8) ;
        FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, content) ;
        response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain") ;
        response.headers().set(HttpHeaderNames.CONTENT_LENGTH, content.readableBytes()) ;
        channelHandlerContext.writeAndFlush(response) ;
    }
}
