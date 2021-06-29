module.exports = {
    devServer: {
        proxy: {
            '/board': {
                target: 'http://localhost:8081',
                ws: true,
                changeOrigin: true
            }
        }
    }
}