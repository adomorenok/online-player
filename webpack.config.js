var webpack = require('webpack');
var CopyWebpackPlugin = require('copy-webpack-plugin');
var ExtractTextPlugin = require('extract-text-webpack-plugin');

var config = {
    context: __dirname + '/online-player-ui/src',
    entry: {
        index: './js/index'
    },

    output: {
        path: __dirname + '/online-player-ui/dist/js/',
        filename: '[name].js',
        library: '[name]'
    },

    devtool: '#cheap-module-source-map',

    resolve: {
        alias: {
            'ui-lite': 'ui-lite/dist/js/ui-lite.js'
        }
    },

    module: {
        loaders: [
            {
                test: /\.(js|jsx)$/,
                exclude: /node_modules/,
                loader: 'babel-loader',
                query: {
                    presets: ['es2015', 'stage-2', 'react']
                }
            },
            {
                test: '/ui-lite/dist/js/ui-lite.js',
                loader: 'exports?window.ui'
            },
            {
                test: /\.(html)$/,
                exclude: /\/node_modules\//,
                loader: 'file?name=../[path][name].[ext]'
            },
            {
                test: /\.scss$/,
                loader: ExtractTextPlugin.extract({
                    fallback: './scss/app.scss',
                    use: ['style-loader', 'css-loader!resolve-url!sass-loader?sourceMap']
                })
            }
        ],
        rules: [
            {
                test: /\.scss$/,
                use: ExtractTextPlugin.extract({
                    fallbackLoader: 'style-loader',
                    loader: ['css-loader', 'sass-loader'],
                    publicPath: '/online-player-ui/dist/css'
                })
            },
            {
                test: /\.(js|jsx)$/,
                use:  [
                    { loader: 'babel-loader', options: { presets: ['es2015', 'react', 'stage-2'] } }
                ],
                exclude: /node_modules/,
            }
        ]
    },

    plugins: [
        new CopyWebpackPlugin([
            {from: './*.html', to: '../'},
            {from: './*/*.html', to: '../'}
        ]),
        new ExtractTextPlugin({
            filename:'../style/app.css',
            allChunks: true
        })
    ],

    watch: true,
    watchOptions: {
        ignored: '/node_modules/'
    }
};

module.exports = config;