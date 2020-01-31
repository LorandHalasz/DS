import React from 'react'
import logo from './commons/images/icon.png';

import {
    DropdownItem,
    DropdownMenu,
    DropdownToggle,
    Nav,
    Navbar,
    NavbarBrand,
    NavLink,
    UncontrolledDropdown
} from 'reactstrap';
import Button from "react-bootstrap/Button";
import Login from "./Login";
import WrapperComponent from "./Login";

const textStyle = {
    color: 'white',
    textDecoration: 'none'
};

const NavigationBarWithMenu = () => (
    <div>
        <Navbar color="dark" light expand="md">
            <NavbarBrand href="/">
                <img src={logo} width={"50"}
                     height={"35"} />
            </NavbarBrand>
            <Nav className="mr-auto" navbar>

                <UncontrolledDropdown nav inNavbar>
                    <DropdownToggle style={textStyle} nav caret>
                       Menu
                    </DropdownToggle>
                    <DropdownMenu right >

                        <DropdownItem>
                            <NavLink href="/doctors">Patients</NavLink>
                            <NavLink href="/doctors_page2">Caregivers</NavLink>
                            <NavLink href="/doctors_page3">Medications</NavLink>
                            <NavLink href="/doctors_page4">Medication plans</NavLink>
                            <NavLink href="/doctors_page5">Medication per plans</NavLink>
                        </DropdownItem>


                    </DropdownMenu>
                </UncontrolledDropdown>

            </Nav>
            <Login/>
        </Navbar>
    </div>
);


export default NavigationBarWithMenu
