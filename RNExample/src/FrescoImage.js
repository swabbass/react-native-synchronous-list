import PropTypes from 'prop-types';
import {requireNativeComponent, ViewPropTypes} from 'react-native';


var iface = {
    name: 'FrescoImageView',
    propTypes: {
        src: PropTypes.string,
        ...ViewPropTypes,
    }
};


module.exports=requireNativeComponent('FrescoImageView',iface);