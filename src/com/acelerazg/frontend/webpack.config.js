const path = require('path')
const CopyPlugin = require('copy-webpack-plugin')

module.exports = {
    mode: 'development',
    entry: './recursos/Main.ts',
    devServer: {
        static: {
            directory: path.join(__dirname, 'dist')
        },
        port: 9000,
        hot: true,
    },
    output: {
        filename: 'app.min.js',
        path: path.join(__dirname, 'dist'),
        publicPath: '/'
    },
    plugins: [
      new CopyPlugin({
          patterns: [{from: 'publico'}]
      }),
    ],
    resolve: {
        extensions: [ '.ts', '.js']
    },
    module: {
        rules: [{
            test: /\.ts$/,
            use: 'ts-loader',
            exclude: /node_modules/
        }]
    }

}