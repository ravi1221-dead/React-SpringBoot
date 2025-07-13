import { NavLink } from 'react-router-dom';
import logo from '../assets/logo.png';

const Logo = () => {
  return (
    <NavLink className="navbar-brand" to="/">
        <img src={logo} alt='Logo' width={60} height={60} className='rounded-circle'/>
    </NavLink>
  )
}

export default Logo;