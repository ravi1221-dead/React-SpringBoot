import logo from '../assets/logo.png';

const Logo = () => {
  return (
    <a className="navbar-brand" href="#">
        <img src={logo} alt='Logo' width={60} height={60} className='rounded-circle'/>
    </a>
  )
}

export default Logo;