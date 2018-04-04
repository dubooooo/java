import asyncio
import logging

from aiohttp import web

logging.basicConfig(level=logging.INFO)


def index(request):
    return web.Response(body="hello world")


@asyncio.coroutine
def init(loop):
    app = web.Application(loop=loop)
    app.router.add_route("GEt", "/", index)
    srv = yield from loop.create_server(app.make_handler(), "127.0.0.1", "8080")
    logging.info("server started at http://127.0.0.1:8080")
    return srv


loop = asyncio.get_event_loop()
loop.run_until_complete(init(loop))
loop.run_forever()
