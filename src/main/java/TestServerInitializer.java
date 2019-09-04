import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.http.HttpServerCodec;

public class TestServerInitializer extends ChannelInitializer {

    @Override
    protected void initChannel(Channel channel) throws Exception {
        ChannelPipeline pipeline = channel.pipeline() ;
        pipeline.addLast("httpServerCodec", new HttpServerCodec()) ;
        pipeline.addLast("testHttpserverHandler", new TestHttpserverHandler()) ;
    }
}
