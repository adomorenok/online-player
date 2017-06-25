var webpack = require('webpack');
var CopyWebpackPlugin = require('copy-webpack-plugin');
var ExtractTextPlugin = require('extract-text-webpack-plugin');

var config = {
    context: __dirname + '/online-player-ui/src',
    entry: {
        index: './js/index',
        trackList: './js/music/track-list',
        addTrack: './js/music/add-track'
    },

    output: {
        path: __dirname + '/online-player-ui/dist/js/',
        filename: '[name].js',
        library: '[name]'
    },

    devtool: '#cheap-module-source-map',

    externals: {
        "jquery.js": "jquery"
    },

    resolve: {
        alias: {
            'ui-lite': 'ui-lite/dist/js/ui-lite.js'
        }
    },

    module: {
        loaders: [
            {
                test: /\.js?$/,
                exclude: /node_modules/,
                loader: 'babel-loader',

                query: {
                    presets: ['es2015']
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
                    use: ['css-loader', 'resolve-url', 'sass-loader?sourceMap']
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