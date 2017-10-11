var webpack = require("webpack");
var path = require("path");

module.exports = {
    entry: path.resolve(__dirname, "build/classes/kotlin/main/min/frontend.js"),
    output: {
        path: path.resolve(__dirname, "../backend/src/main/resources/static"),
        filename: "bundle.js"
    },
    resolve: {
        alias: {
            kotlin: path.resolve(__dirname, "build/classes/kotlin/main/min/kotlin.js")
        }
    },
    plugins: [
        new webpack.optimize.UglifyJsPlugin()
    ]
};