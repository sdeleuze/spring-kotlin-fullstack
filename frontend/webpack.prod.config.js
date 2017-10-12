var webpack = require("webpack");
var path = require("path");
var CopyWebpackPlugin = require('copy-webpack-plugin');

module.exports = {
    entry: path.resolve(__dirname, "build/classes/kotlin/main/min/frontend.js"),
    output: {
        path: path.resolve(__dirname, "build/web"),
        filename: "bundle.js"
    },
    resolve: {
        alias: {
            kotlin: path.resolve(__dirname, "build/classes/kotlin/main/min/kotlin.js")
        }
    },
    plugins: [
        new webpack.optimize.UglifyJsPlugin(),
        new CopyWebpackPlugin([{ from: path.resolve(__dirname, "src/main/web") }])
    ]
};